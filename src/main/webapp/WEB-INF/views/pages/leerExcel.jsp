<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 19/04/2018
  Time: 04:01 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="ui positive message">
    <i class="close icon"></i>
    <div class="header">
        Exito!!
    </div>
    <p>Se ha subido con exito el archivo</p>
</div>
<script>
    $('.message .close')
        .on('click', function() {
            $(this)
                .closest('.message')
                .transition('fade')
            ;
        })
    ;
</script>