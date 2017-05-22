document.addEventListener('DOMContentLoaded', function() {

  const color = document.getElementById('inputCor');

    document.getElementById('btnPesquisar').onclick = () => {
      Object.values(hexToRgb(color.value)).forEach(item => {
        fetch(`http://pokeapi.co/api/v2/pokemon/${item}`).then(response => response.json())
          .then(json => render(json));
      });
    }

  function render(json) {

    document.getElementsByTagName("body")[0].style.background = color.value;
     let div = document.getElementById("elementosPokemon");
     let img = document.createElement("img"); 
     img.src = json.sprites.front_default;
     let nomePoke = document.createElement("h3");
     nomePoke.innerText = json.name;
     let numeroPoke = document.createElement("h3");
     numeroPoke.innerText = json.id;
     let listaPoke = document.createElement("h3");
         json.types.forEach(type => {
         let item = document.createElement("h4");
         item.innerHTML = type.type.name;
         listaPoke.appendChild(item);
     });
     div.appendChild(nomePoke);
     div.appendChild(numeroPoke);
     div.appendChild(img);
     div.appendChild(listaPoke);
 }
 
  function hexToRgb(hex) {
    var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
    return result ? {
        r: parseInt(result[1], 16),
        g: parseInt(result[2], 16),
        b: parseInt(result[3], 16)
    } : null;
  } 
});