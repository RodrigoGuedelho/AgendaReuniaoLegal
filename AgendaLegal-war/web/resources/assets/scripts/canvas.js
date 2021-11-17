window.onload = function(){
    // get the canvas DOM element by its ID
    var canvas = document.getElementById("logoCanvas");
    // declare a 2D context using the getContext() method of the canvas object
    var context = canvas.getContext("2d");
				
    // context.translate(canvas.width/2, canvas.height/2);
    // set the line width to 10 pixels
    context.lineWidth = 3.5;
    // set the line color
    context.strokeStyle = "#2F2F2F";
				
    // Topo
    context.moveTo(220, 172); // 1
    context.lineTo(198, 175); // 2
    context.lineTo(176, 180); // 3
    context.lineTo(118, 112); // 4

    // Lado esquerdo
    context.lineTo(160, 200); // 5
    context.lineTo(139, 227); // 6
    context.lineTo(192, 247); // 7
    context.lineTo(219, 323); // 8

    // 
    context.lineTo(200, 207); // 9
    context.lineTo(220, 207); // 10
    context.lineTo(200, 207); // 11
    context.lineTo(176, 180); // 12

    context.lineTo(160, 200); // 13
    context.lineTo(168, 218); // 14
    context.lineTo(139, 227); // 15
    context.lineTo(168, 218); // 16

    context.lineTo(192, 247); // 17
    context.lineTo(200, 207); // 18
    context.lineTo(168, 218); // 19
    context.lineTo(205, 240); // 20

    context.lineTo(192, 247); // 21
    context.lineTo(176, 180); // 22
    context.lineTo(192, 247); // 23
    context.lineTo(220, 248); // 24
				
    context.stroke();
				
				
    context.scale(-1, 1);
    context.translate(-439, 0);
			    
    context.moveTo(220, 172); // 1
    context.lineTo(198, 175); // 2
    context.lineTo(176, 180); // 3
    context.lineTo(118, 112); // 4

    // Lado esquerdo
    context.lineTo(160, 200); // 5
    context.lineTo(139, 227); // 6
    context.lineTo(192, 247); // 7
    context.lineTo(219, 323); // 8

    // 
    context.lineTo(200, 207); // 9
    context.lineTo(220, 207); // 10
    context.lineTo(200, 207); // 11
    context.lineTo(176, 180); // 12

    context.lineTo(160, 200); // 13
    context.lineTo(168, 218); // 14
    context.lineTo(139, 227); // 15
    context.lineTo(168, 218); // 16

    context.lineTo(192, 247); // 17
    context.lineTo(200, 207); // 18
    context.lineTo(168, 218); // 19
    context.lineTo(205, 240); // 20

    context.lineTo(192, 247); // 21
    context.lineTo(176, 180); // 22
    context.lineTo(192, 247); // 23
    context.lineTo(220, 248); // 24
				
    context.stroke();
};