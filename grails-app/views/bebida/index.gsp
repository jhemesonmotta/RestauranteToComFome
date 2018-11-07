<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'bebida.label', default: 'Bebida')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
<!--        <a href="#list-bebida" class="skip" tabindex="-1">
            <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
        </a>-->
        <br/><br/>
        <div class="nav" role="navigation">
            <ul>
                <li>
                    <g:link class="btn btn-success float-right" action="create">
                        Cadastrar Bebida
                    </g:link>
                </li>
            </ul>
        </div>
        <div id="list-bebida" class="content scaffold-list" role="main">
            <h1>
                Bebidas Cadastradas
            </h1>
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            
            <f:table collection="${bebidaList}" displayStyle="table" />

            <div class="pagination">
                <g:paginate total="${bebidaCount ?: 0}" />
            </div>
        </div>
    </body>
</html>