'use strict';

const TITLE = document.querySelector("#movietitle")
const YEAR = document.querySelector("#year")
const RATING = document.querySelector("#rating")
const GENRE = document.querySelector("#genre")

const ALERT = document.querySelector("#onSuccess");

const ENTRY = document.getElementById("#read");

const createEntry = (e) => {
    e.preventDefault();
    console.log("hiiii");
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
        .then((resp) => {
            console.log(resp);
            ALERT.setAttribute("class", "alert alert-successful");
            ALERT.innerHTML = "Movie Entry Created!";
            setTimeout(() => {
                ALERT.removeAttribute("class");
                ALERT.innerHTML = "";
            }, 3000);
        })

        .catch((err) => console.log(err));


    function readEntry() {
        axios.get("http://localhost:8080/getAll")
            .then(resp => {
                ENTRY.innerHTML = "";
                const entries = resp.obj;
                entries.forEach(entry => {
                    const newEntry = createCard(entry);
                    ENTRY.appendChild(newEntry);
                });
            }).catch(err => console.error(err))
    }

    function createCard(entry) {
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
        movieTitle.innerText = "Movie Title " + entry.TITLE_VALUE; /////change .name
        entryBody.appendChild(movieTitle);

        const releaseYear= document.createElement("p");
        releaseYear.className = "card-text";
        releaseYear.innerText = "Release Year " + entry.YEAR_VALUE; /////change .year
        entryBody.appendChild(releaseYear);

        const rating= document.createElement("p");
        rating.className = "card-text";
        rating.innerText = "Rating " + entry.RATING_VALUE; /////change .rate
        entryBody.appendChild(releaseYear);
            
        const genre= document.createElement("p");
        genre.className = "card-text";
        genre.innerText = "Genre " + entry.GENRE_VALUE; /////change .gen
        entryBody.appendChild(genre);
             
        const deleteButton= document.createElement("h4");
        deleteButton.className = "card-link";
        deleteButton.innerText = "Delete";
        deleteButton.addEventListener('click', () => deleteEntry(entry.id));
        entryBody.appendChild(deleteButton);

        const updateButton= document.createElement("h4");
        updateButton.className = "card-link";
        updateButton.innerText = "Update";
        updateButton.addEventListener('click', () => updateEntry(entry.id));
        entryBody.appendChild(updateButton);

        return newColumn;
    }

    function updateEntry(id) {
        axios.put("http://localhost:8080/update/" + id).then(() => readEntry()).
            catch(err => console.error(err));
    } /////create modal to make the updates

    function deleteEntry(id) {
        axios.delete("localhost:8080/remove/" + id).then(() => readEntry()).catch(err => console.error(err));
    }

}

