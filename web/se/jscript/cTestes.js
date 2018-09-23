$(document).ready(function(){
        $('a[href^="http://"]').each(function(){ 
            var oldUrl = $(this).attr("href"); // Get current url
            var newUrl = oldUrl.replace("http://", "https://"); // Create new url
            $(this).attr("href", newUrl); // Set herf value
        });
    });

