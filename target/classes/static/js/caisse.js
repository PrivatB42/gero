$(function() {

    function savevente(){

        console.log("Saving event to ")

        $.ajax({
           /*type: 'POST',*/
           method: "POST",
           url: '/vente/save',
           success : function(response){
                console.log(response);
           },
           error: function(response){
                console.log(response);
           }
        });


      /*  $.post("https://jsonplaceholder.typicode.com/users", (data, status) => {
          console.log(data);
        });*/

        $("td").empty();
        $("#ttph").empty();
        $("#ttph").text("0");
        console.log("Enregistrement reussie");

    }


    function isEmpty( el ){
        return !$.trim(el.html())
    }



   $( ".ser" ).autocomplete({
      source: "/autocomplete"
   });

   $("#btnvendre").click(function(){

        if (isEmpty($('#tr'))){
            alert("Veuillez saisir au moins un produit");
        }else{
            savevente();
            alert("Vente effectuée avec succes");
        }

   });

   /*$("#trv").click(function(e){
        var ve = 0;
        console.log("ve ", ve);
        while(ve == 0){
            $("#yt").click();
            console.log("tttttttttttttttttttttttttttttttttttttttttttt");
            ve = ve + 1;
            console.log("ve ", ve);
        }
   });*/


  /* var d = new Date();
   var date = d.getFullYear()+'-'+(d.getMonth()+1)+'-'+d.getDate();
   var hours = d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds();
   var fullDate = date+' '+hours;
   console.log(fullDate);*/



});