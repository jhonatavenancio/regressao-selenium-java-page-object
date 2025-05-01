window.onload = function () {
    const progresso = document.getElementById("id-barra-progresso");
    const tempo = document.getElementById("id-tempo-restante");
  
    if (progresso) {
      let segundos = 0;
      const intervalo = setInterval(() => {
        segundos++;
        progresso.value = segundos;
        tempo.textContent = `${30 - segundos} segundos restantes`;
  
        if (segundos >= 30) {
          clearInterval(intervalo);
          window.location.href = "concluido.html";
        }
      }, 1000);
    }
  };
  