package com.perficient.aem.datalayer.core.filters;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.perficient.aem.datalayer.api.DataLayer;
import com.perficient.aem.datalayer.core.models.AEMDataLayerConfig;
import com.perficient.aem.datalayer.test.SomeResourceTypeModel;

import io.wcm.testing.mock.aem.junit.AemContext;

public class AEMDataLayerInterceptorFilterTest {

	@Rule
	public AemContext context = new AemContext(ctx -> {
		ctx.registerService(AEMDataLayerInterceptorFilter.class, new AEMDataLayerInterceptorFilter());
	});

	@Before
	public void setup() {
		context.load().json("/test-pages.json", "/test");
		context.load().json("/cloud-config.json", "/etc/cloudservices");
		context.load().json("/resource-types.json", "/apps");

		context.addModelsForClasses(SomeResourceTypeModel.class, AEMDataLayerConfig.class);
	}

	@Test
	public void testAttributesCreated() throws IOException, ServletException {
		FilterChain filterChain = mock(FilterChain.class);
		AEMDataLayerInterceptorFilter filter = context.getService(AEMDataLayerInterceptorFilter.class);

		context.currentPage("/test/page-with-cloud-config");
		SlingHttpServletRequest request = spy(context.request());

		filter.doFilter(request, context.response(), filterChain);

		verify(request, atLeastOnce()).setAttribute(eq("AEM_DATALAYER"), any(DataLayer.class));
		verify(request, atLeastOnce()).setAttribute(eq("AEM_DATALAYER_APPLICABLE"), eq(Boolean.TRUE));
	}

	@Test
	public void testAttributesNotCreated() throws IOException, ServletException {
		FilterChain filterChain = mock(FilterChain.class);
		AEMDataLayerInterceptorFilter filter = context.getService(AEMDataLayerInterceptorFilter.class);

		context.currentPage("/test/page-without-cloud-config");
		SlingHttpServletRequest request = spy(context.request());

		filter.doFilter(request, context.response(), filterChain);

		verify(request, never()).setAttribute(eq("AEM_DATALAYER"), any(DataLayer.class));
		verify(request, atLeastOnce()).setAttribute(eq("AEM_DATALAYER_APPLICABLE"), eq(Boolean.FALSE));
	}

	@Test
	public void testResourceTypeHierarchyWithNoCycle() throws IOException, ServletException {
		AEMDataLayerInterceptorFilter filter = context.getService(AEMDataLayerInterceptorFilter.class);

		context.currentPage("/test/page-with-cloud-config");

		assertThat(filter.resourceHierarchyHasACycle(context.currentResource())).as("has a cycle should be false")
				.isFalse();
	}

	@Test
	public void testResourceTypeHierarchiesWithCycles() throws IOException, ServletException {
		AEMDataLayerInterceptorFilter filter = context.getService(AEMDataLayerInterceptorFilter.class);

		context.currentPage("/test/pages-with-cycles/with-a-self-cycle");

		assertThat(filter.resourceHierarchyHasACycle(context.currentResource())).as("has a self cycle, should be true")
				.isTrue();

		context.currentPage("/test/pages-with-cycles/with-a-parent-child-cycle");

		assertThat(filter.resourceHierarchyHasACycle(context.currentResource()))
				.as("has a parent/child cycle, should be true").isTrue();

		context.currentPage("/test/pages-with-cycles/with-a-grandparent-child-cycle");

		assertThat(filter.resourceHierarchyHasACycle(context.currentResource()))
				.as("has a grandparent/child cycle, should be true").isTrue();

		context.currentPage("/test/pages-with-cycles/with-a-grandparent-parent-cycle");

		assertThat(filter.resourceHierarchyHasACycle(context.currentResource()))
				.as("has a grandparent/parent cycle, should be true").isTrue();
	}

}
