<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title><decorator:title default="POCC-PocCobol"/></title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link href="<s:url value="/includes/css/master.css"/>" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="<s:url value='/includes/js/jquery-1.4.2.js'/>"></script>
	<decorator:head />
</head>
<body>
<table id="tabela_principal">
	<tr>
		<td>
			<span class="titulo"><decorator:getProperty property="meta.titulo" default="POCC-PocCobol"/></span> <br />
			<span class="subtitulo"><decorator:getProperty property="meta.subtitulo" /></span> <br />
			<br />
			<s:if test="hasFieldErrors()">
				<table width="100%" border="0" cellpadding="5" cellspacing="0" class="tabela_verm" id="msgErros">
					<tbody>
						<tr>
							<td><s:iterator value="fieldErrors">
								<li><s:property value="value[0]" /></li>
							</s:iterator></td>
						</tr>
					</tbody>
				</table>
			</s:if>
			<s:if test="hasActionErrors()">
				<table width="100%" border="0" cellpadding="5" cellspacing="0" class="tabela_verm" id="msgErros">
					<tbody>
						<tr>
							<td><s:iterator value="actionErrors">
								<li><s:property /></li>
							</s:iterator></td>
						</tr>
					</tbody>
				</table>
			</s:if>
			<s:if test="hasActionMessages()">
				<table width="100%" border="0" cellpadding="5" cellspacing="0" class="tabela_sucesso" id="msgSucesso">
					<tbody>
						<tr>
							<td><s:iterator value="actionMessages">
								<li><s:property /></li>
							</s:iterator></td>
						</tr>
					</tbody>
				</table>
			</s:if>
			 <br />
			<decorator:body />
		</td>
	</tr>
</table>
<%--
<s:if test="hasActionMessages()">
	<script>
		$("#msgSucesso").fadeOut(7000);
	</script>
</s:if>
 --%>
</body>
</html>
