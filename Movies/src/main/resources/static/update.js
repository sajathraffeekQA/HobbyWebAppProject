'use strict'

const UPDATEDTITLE = document.querySelector("#updatetitle")
const UPDATEDYEAR = document.querySelector("#updateyear")
const UPDATEDRATING = document.querySelector("#updaterating")
const UPDATEDGENRE = document.querySelector("#updategenre")

const updateMethod = (id) => {
    axios.get("http://localhost:8080/getOne/" + id)
    .then((response) => {
        console.log(response.data);
        updateFields(response.data)
    }).catch(err => console.error(err.response));
}

const params = new URLSearchParams(window.location.search)
for (const param of params) {
  console.log(param)
  let id = param[0]
  updateMethod(id)
}

const updateFields = (response) => {
    
document.getElementById("updateTitle").value = response.movieTitle;
document.getElementById("updateYear").value = response.releaseYear;
document.getElementById("updateRating").value = response.rating;
document.getElementById("updateGenre").value = response.genre;
}



//UPDATE METHOD
const updateEntry = (e) => {
    e.preventDefault();
   
    const UPDATED_TITLE_VALUE = UPDATEDTITLE.value;
    const UPDATED_YEAR_VALUE = UPDATEDYEAR.value;
    const UPDATED_RATING_VALUE = UPDATEDRATING.value;
    const UPDATED_GENRE_VALUE = UPDATEDGENRE.value;
    
        console.log(UPDATED_TITLE_VALUE, UPDATED_YEAR_VALUE, UPDATED_RATING_VALUE, UPDATED_GENRE_VALUE);
    const object = {
        movieTitle: UPDATED_TITLE_VALUE,
        releaseYear: UPDATED_YEAR_VALUE,
        rating: UPDATED_RATING_VALUE,
        genre: UPDATED_GENRE_VALUE
    };

    //console.log(object);

    axios.put("http://localhost:8080/update/" + id, object).then((response) => console.log(response))
    .catch(err => console.error(err));
}


