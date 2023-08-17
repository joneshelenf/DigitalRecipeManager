window.addEventListener("load", function(){
// add link to API URL from recipeServices class findRecipeByMeal
    this.fetch('https://www.themealdb.com/api/json/v1/1/search.php?s=')
    .then(function(response){
        return response.json();
    }).then(function(response){
        //push out each recipe to the screen
    //get our element
    let myContainer = document.getElementById('container');
    //run a loop
    let allMyHTML="";
    for(let i=0; i<response.length; i++){
        let myHTML= `
        <div class="recipe">

        // firstName = strMeal (recipe title)
        // lastName = description
        // hours in space = cookingTime
        // active = strTags
        // skills = instructions

       <div class="bio">
          <h3>${response[i].strMeal} ${response[i].description}</h3>
          <ul>
             <li>Cooking Time: ${response[i].cookingTime}</li>
             <li>Diet Type:${response[i].strTags}</li>
             <li>Instructions: ${response[i].instructions}</li>
          </ul>
       </div>
       // class=avatar is now class=recipePicture
       <img class="recipePicture" src="${response[i].picture}">
    </div>
        `;

        allMyHTML += myHTML;
    }
    myContainer.innerHTML=allMyHTML
    })
    });
