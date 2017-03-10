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

   Adds the DataLayer to the page.

--%><%@page session="false"%><%@include file="/libs/foundation/global.jsp"%><%@taglib prefix="sling2" uri="http://sling.apache.org/taglibs/sling" %>
<sling2:adaptTo var="dataLayer" adaptable="${currentPage.contentResource}" adaptTo="com.perficient.aem.datalayer.core.models.AEMDataLayerManager" />
<script>
	window.${dataLayer.config.objectName} = ${dataLayer.json}
</script>
