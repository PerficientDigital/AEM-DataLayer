<%--

  ADOBE CONFIDENTIAL
  __________________

   Copyright 2015 Adobe Systems Incorporated
   All Rights Reserved.

  NOTICE:  All information contained herein is, and remains
  the property of Adobe Systems Incorporated and its suppliers,
  if any.  The intellectual and technical concepts contained
  herein are proprietary to Adobe Systems Incorporated and its
  suppliers and are protected by trade secret or copyright law.
  Dissemination of this information or reproduction of this material
  is strictly forbidden unless prior written permission is obtained
  from Adobe Systems Incorporated.

--%><%@page session="false"%><%--
    Open configuration dialog if the property designated by "connectedWhen" is filled in.
    Derived components may override this to change the opening condition.
    --%>
<%@include file="/libs/foundation/global.jsp"%>
<%@include file="/libs/cq/cloudserviceconfigs/components/configpage/init.jsp"%>
<% if (((String)properties.get("environment", "")).trim().equals("")) { %>
    <script type="text/javascript">
        CQ.WCM.onEditableReady("<%= xssAPI.encodeForJSString(resource.getPath()) %>", function(editable){
            CQ.wcm.EditBase.showDialog(editable);
        }, this);
        </script>
<% } %>

