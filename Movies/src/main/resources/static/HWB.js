'use strict';

const TITLE = document.querySelector("#movietitle")
const YEAR = document.querySelector("#year")
const RATING = document.querySelector("#rating")
const GENRE = document.querySelector("#genre")

const ALERT = document.querySelector("#onSuccess");

const ENTRY = document.querySelector("#read");

const UPDATEMODAL = document.getElementById("#updateModal")



//CREATE METHOD
const createEntry = (e) => {
    e.preventDefault();
    //console.log("hiiii");
    const TITLE_VALUE = TITLE.value;
    const YEAR_VALUE = YEAR.value;
    const RATING_VALUE = RATING.value;
    const GENRE_VALUE = GENRE.value;

    // console.log(`${TITLE_VALUE}` `$YEAR_VALUE` `$RATING_VALUE` `$GENRE_VALUE`);
    console.log(TITLE_VALUE, YEAR_VALUE, RATING_VALUE, GENRE_VALUE);
    const obj = {
        movieTitle: TITLE_VALUE,
        releaseYear: YEAR_VALUE,
        rating: RATING_VALUE,
        genre: GENRE_VALUE
    };

    console.log(obj);

    axios.post("http://localhost:8080/create", obj)
        .then((response) => {
            console.log(response);
            ALERT.setAttribute("class", "alert alert-successful");
            ALERT.innerHTML = "Movie Entry Created!";
            setTimeout(() => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = "";
            }, 5000);
        })

        .catch((err) => console.log(err));

}

//READ ALL METHOD
const readEntry = () => {
    axios.get("http://localhost:8080/getAll")
        .then((response) => {
            console.log(response);
            // ENTRY.innerHTML = "";
            const entries = response.data;
            entries.forEach(entry => {
                const newEntry = createCard(entry);
                console.log(newEntry);
                ENTRY.appendChild(newEntry);
            });
        }).catch(err => console.error(err.response))
}

const createCard = (entry) => {
    const newColumn = document.createElement("div");
    newColumn.className = "col";

    const newEntry = document.createElement("div");
    newEntry.className = "card";
    newColumn.appendChild(newEntry);

    const entryBody = document.createElement("div");
    entryBody.className = "card-body";
    newEntry.appendChild(entryBody);

    const movieTitle = document.createElement("p");
    movieTitle.className = "card-text";
    movieTitle.innerText = "Movie Title: " + entry.movieTitle;
    entryBody.appendChild(movieTitle);

    const releaseYear = document.createElement("p");
    releaseYear.className = "card-text";
    releaseYear.innerText = "Release Year: " + entry.releaseYear;
    entryBody.appendChild(releaseYear);

    const rating = document.createElement("p");
    rating.className = "card-text";
    rating.innerText = "Rating: " + entry.rating;
    entryBody.appendChild(rating);

    const genre = document.createElement("p");
    genre.className = "card-text";
    genre.innerText = "Genre: " + entry.genre;
    entryBody.appendChild(genre);

    const updateButton = document.createElement("a");
    updateButton.className = "card-link";
    updateButton.innerText = "Update";
    updateButton.href = "/update.html?" + entry.id;
    //updateButton.addEventListener('click', () => updateEntry(entry.id));

    entryBody.appendChild(updateButton);

    const deleteButton = document.createElement("a");
    deleteButton.className = "card-link";
    deleteButton.innerText = "Delete";
    deleteButton.addEventListener("click", () => deleteEntry(entry.id));
    entryBody.appendChild(deleteButton);

    return newColumn;
}

//DELETE METHOD
const deleteEntry = (id) => {
    axios.delete("http://localhost:8080/remove/" + id)
        .then(() => location.reload())
        .catch(err => console.error(err));
}



readEntry();