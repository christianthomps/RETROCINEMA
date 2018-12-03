<!DOCTYPE html>
<html lang="en" href="style.css" href="//fonts.googleapis.com/css?family=Play">
<head>
    <link href="style.css" rel="stylesheet" type="text/css" media="all">
    <link href="moviePageStyle.css" rel="stylesheet" type="text/css" media="all">
    <link href="movieStyle.css" rel="stylesheet" type="text/css" media="all">

    <meta charset="UTF-8">
    <title>Cinema</title>
</head>

<body>
<!-Link map for header-->
<map name="header-links">
    <area target="" alt="browse" title="browse" href="Browse.jsp" coords="227,204,347,237" shape="rect">
    <area target="" alt="account" title="account" href="signin.jsp" coords="353,203,473,237" shape="rect">
    <area target="" alt="home" title="home" href="index.jsp" coords="154,79,532,168" shape="rect">
</map>

<div id="wrapper">
    <div class="header">
        <div id="header-img"><img usemap="#header-links" src="Images/retroheader3.png"/></div>
    </div>

        <div class="contentBox">
            <div id="movieContent">

                <img class="moviePoster" src="${poster}">

                <div id="movieDescription">
                    <h2 name="title">${title}</h2>
                    <p>Producer(s): ${producer}</p>
                    <p>Cast: ${cast}</p>
                </div>
                <select name="showTime">
                    ${showTimeHTML}
                </select>
            </div>
        </div>

        <div id="purchaseSection">
            <p>Number of tickets</p>
            <form action="selectSeatsServlet" method="post">
                Senior
                <select name="SeniorTicketNo">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                Adult
                <select name="AdultTicketNo">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                Under 18
                <select name="MinorTicketNo">
                    <option value="0">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
                <p>
                    <input type="text" name="promoCode"/><button>Add Promo Code</button>
                </p>
                <p>
                <div id="selectSeatsButton">
                    <button type="submit">Select Seats</button>
                </div>
                </p>
            </form>
        </div>
    </div>

    <div id="footer">

    </div>
</div>
</body>
</html>