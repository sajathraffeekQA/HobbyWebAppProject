'use strict';

const TITLE = document.querySelector("#movietitle")
const YEAR = document.querySelector("#year")
const RATING = document.querySelector("#tickmarks")
const GENRE = document.querySelector("#genre")

const ALERT = document.querySelector("#onSuccess");


const createEntry = () => {

    const TITLE_VALUE = TITLE.value;
    const YEAR_VALUE = YEAR.value;
    const RATING_VALUE = RATING.value;
    const GENRE_VALUE = GENRE.value;

    console.log(`$(TITLE_VALUE)` `$YEAR_VALUE` `$RATING_VALUE` `$GENRE_VALUE`);

    Let obj = {

        "movieTitle": TITLE_VALUE,
        "releaseYear": YEAR_VALUE,
        "rating": RATING_VALUE,
        "genre": GENRE_VALUE
    };


    axios.post(localhost:8080/create, obj)
    .then((resp)  => console.log(resp);
    ALERT.setAttribute("class", "alert alert-successful");
    ALERT.innerHTML = "Movie Entry Created!";

    )
    
    .catch((err) => console.log(err));

}
