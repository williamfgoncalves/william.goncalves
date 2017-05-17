document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    var campo = document.getElementById('numeroPokemon').value;
    var url = "http://pokeapi.co/api/v2/pokemon/" + campo + "/";
    fetch(url)
            .then(response => response.json())
            .then(json => {
            addToHtml(json);
            status(json);
            console.log(json);
            
         })
    }
});

function addToHtml(json){
    let div = document.getElementById("elementosPokemon");
    let img = document.createElement("img"); 
    img.src = json.sprites.front_default;
    let nomePoke = document.createElement("h3");
    nomePoke.innerText = json.name;
    let numeroPoke = document.createElement("h3");
    numeroPoke.innerText = json.id;
    let listaPoke = document.createElement("ul");
        json.types.forEach(type => {
        let item = document.createElement("li");
        item.innerHTML = type.type.name;
        listaPoke.appendChild(item);
    });
    div.appendChild(nomePoke);
    div.appendChild(numeroPoke);
    div.appendChild(img);
    div.appendChild(listaPoke);
}

function status(json){
    let div = document.getElementById("elementosPokemon");
    json.stats.forEach(stat => {
        let progress = document.createElement("progress");
        let statusPoke = document.createElement("h6");
        statusPoke.innerText = stat.stat.name;
        progress.max = 100;
        progress.value = stat.base_stat;
        div.appendChild(statusPoke);
        div.appendChild(progress);
    });
}
