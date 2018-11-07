<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'bebida.label', default: 'Bebida')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <br/><br/>
        <div class="nav" role="navigation">
            <ul>
                <li>
                    <g:link class="list" action="index">
                        Listagem
                    </g:link>
                </li>
            </ul>
        </div>
        <div id="create-bebida" class="content scaffold-create" role="main">
            <h1>
                Cadastrar Bebida
            </h1>
            <g:hasErrors bean="${this.bebida}">
                <ul class="errors" role="alert">
                    <g:eachError bean="${this.bebida}" var="error">
                        <li 
                            <g:if test="${error in org.springframework.validation.FieldError}">
                                data-field-id="${error.field}"
                            </g:if>
                        >
                            <g:message error="${error}"/>
                        </li>
                    </g:eachError>
                </ul>
            </g:hasErrors>
            <g:form resource="${this.bebida}" method="POST">
                <fieldset class="form">                    
                    <div class="fieldcontain required">
                        <label for="liquido">Liquido
                          <span class="required-indicator">*</span>
                        </label>
                        <input type="number" name="liquido" value="${liquido}" required id="liquido">
                    </div>
                    <div class="fieldcontain required">
                        <label for="unidade">Unidade
                          <span class="required-indicator">*</span>
                        </label><input type="text" name="unidade" value="${unidade}" required="" id="unidade">
                    </div>
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
