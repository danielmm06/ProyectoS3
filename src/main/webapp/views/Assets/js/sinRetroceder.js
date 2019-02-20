function deshabilitaRetroceso(){
    window.location.hash="Unillanos";
    window.location.hash="Unillanos" //chrome
    window.onhashchange=function(){window.location.hash="Unillanos";}
}