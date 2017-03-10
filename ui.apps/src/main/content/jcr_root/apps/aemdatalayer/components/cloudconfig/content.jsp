<%--
  Copyright 2017 - Perficient
  
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
	   http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

  ==============================================================================

   Page component for displaying the digitalData configuration.

--%><%@page session="false" contentType="text/html" pageEncoding="utf-8"%>
<%@include file="/libs/foundation/global.jsp"%><cq:setContentBundle />
<h3>
	<fmt:message key="General Settings" />
</h3>
<ul>
	<li><div class="li-bullet">
			<strong><fmt:message key="Environment" /> </strong>
			<c:out value="${properties.environment}" default="Not Set" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Object Name" /> </strong>
			<c:out value="${properties.objectName}" default="Not Set" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Pretty Print" /> </strong>
			<c:out value="${properties.prettyPrint}" default="false" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Site ID" /> </strong>
			<c:out value="${properties.siteId}" default="Not Set" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Site Root Level" /> </strong>
			<c:out value="${properties.siteRootLevel}" default="Not Set" />
		</div></li>
</ul>


<h3>
	<fmt:message key="Page Settings" />
</h3>
<ul>
	<li><div class="li-bullet">
			<strong><fmt:message key="Set Author" /> </strong>
			<c:out value="${properties.setAuthor}" default="false" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Publisher" /> </strong>
			<c:out value="${properties.publisher}" default="Not Set" />
		</div></li>
	<li><div class="li-bullet">
			<strong><fmt:message key="Url Prefix" /> </strong>
			<c:out value="${properties.urlPrefix}" default="Not Set" />
		</div></li>
</ul>


<h3>
	<fmt:message key="Test DataLayer" />
</h3>
<form id="test-form" action="${resource.path}.datalayer.json">
	<label for="path">Path</label><br/>
	<input type="text" required="required" name="path" style="width:75%"/>
	<br/>
	<input type="submit" value="Test" />
</form>
<pre><code id="test-target"></code></pre>
<script>
$('#test-form').submit(function(){
	$('#test-target').text('Loading...');
	$.getJSON($(this).attr('action')+$('input[name=path]').val(), function(data){
		$('#test-target').text(JSON.stringify(data, null, 2));
	}).error(function(jqXHR, textStatus, errorThrown) {
        //alert("Failed to get DataLayer with: " + textStatus +" " + errorThrown);
        $('#test-target').html(jqXHR.responseText);
    });
	return false;
});
</script>