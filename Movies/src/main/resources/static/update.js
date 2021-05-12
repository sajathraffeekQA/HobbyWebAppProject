'use strict'

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
const updateEntry = (id) => {
    console.log(id);
    axios.put("http://localhost:8080/update/" + id).then(() => readEntry())
    .catch(err => console.error(err));
}


