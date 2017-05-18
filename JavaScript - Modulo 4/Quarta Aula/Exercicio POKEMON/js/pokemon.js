document.addEventListener('DOMContentLoaded', function() {
  let btnPesquisar = document.getElementById('btnPesquisar');
  btnPesquisar.onclick = function() {
    var campo = document.getElementById('numeroPokemon').value;
    var url = "http://pokeapi.co/api/v2/pokemon/" + campo + "/";
    fetch(url)
            .then(response => response.json())
            .then(json => {
            addImagem(json)
            addNomePoke(json)
            addIdPoke(json)
            addListaPoke(json)
            status(json);
            console.log(json);
            
         })
    }
});

function addImagem(json){
    let div = document.getElementById("imagemPokemon");
    let img = document.createElement("img"); 
    img.src = json.sprites.front_default;
    div.append(img);
}
function addNomePoke(json){
    let div = document.getElementById("tituloPokemon");
    let nomePoke = json.name;
    div.append(nomePoke);
}
function addIdPoke(json){
    let div = document.getElementById("idPokemon");
    let numeroPoke = json.id;
    div.append(numeroPoke);
}
function addListaPoke(json){
    let div = document.getElementById("listaPokemon");
    let listaPoke = document.createElement("ul");
        json.types.forEach(type => {
        let item = document.createElement("li");
        item.innerHTML = type.type.name;
        listaPoke.appendChild(item);
    });
    div.append(listaPoke);
}

function status(json){
    let div = document.getElementById("progress");
    json.stats.forEach(stat => {
        let progress = document.createElement("progress");
        let statusPoke = document.createElement("h6");
        statusPoke.innerText = stat.stat.name;
        progress.max = 100;
        progress.value = stat.base_stat;
        div.append(statusPoke);
        div.append(progress);
    });
}
