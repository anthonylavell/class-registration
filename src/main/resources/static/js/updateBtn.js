$( document ).ready(function() {
let searchParams = new URLSearchParams(window.location.search);
if(searchParams.has("id")){
    let webPageHref = window.location.href;
    if(webPageHref.indexOf("student") > 0){
        $("#studentBtn").text('Update Student');
    }else{
        $("#courseBtn").text('Update Course');
    }
   
    }
});
