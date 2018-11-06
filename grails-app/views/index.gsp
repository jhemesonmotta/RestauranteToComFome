<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Intranet - Tô Com Fome</title>
</head>
<body>
    <div class="row">
        <div class="col-md-12">
            <h1>Bem-Vindo à Intranet do Restaurante <b>Tô Com Fome</b>!!!</h1>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam ultrices tellus a nulla rhoncus euismod. Aliquam et sollicitudin massa, ac vestibulum orci. Sed luctus orci sed faucibus venenatis. Maecenas congue neque semper justo tincidunt iaculis. Sed malesuada ut purus ac malesuada. Donec in enim porttitor, consectetur lorem in, venenatis odio. Aenean mollis orci enim, vel placerat magna dapibus sed. Duis malesuada aliquet sem, quis volutpat leo gravida dictum. Sed sit amet massa et tellus pharetra dignissim non a lacus. Vestibulum condimentum odio non facilisis scelerisque. Quisque ut orci metus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec ornare, sem non posuere finibus, lectus elit placerat purus, at suscipit lectus augue sit amet ipsum. Suspendisse interdum dolor aliquam purus fermentum, in convallis lectus iaculis. Quisque suscipit leo at ex sollicitudin blandit.
            </p>
            <div id="controllers" role="navigation">
                <h2>Funcionalidades Disponíveis</h2>
                
                <div class="row">
                    <div class="col-12">
                        <g:findAll in="${grailsApplication.controllerClasses.sort { it.fullName } }" expr="it.fullName != 'helloworld.HelloController'">
                           <div class="col-md-4 col-sm-6 col-xs-12">
                               <g:link controller="${it.logicalPropertyName}">${it.logicalPropertyName}</g:link>
                           </div>
                        </g:findAll>
                    </div>
                </div>
            </div>
        </div>
    </div>
            
</body>
</html>
