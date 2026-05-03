console.log("JS conectado");

const form = document.getElementById("formContrato");

form.addEventListener("submit", async function(event) {
    event.preventDefault();

    // 🔹 CAPTURA DOS DADOS
    let nome = document.getElementById("nome").value;
    const nacionalidade = document.getElementById("nacionalidade").value;
    const estadoCivil = document.getElementById("estadoCivil").value;
    const profissao = document.getElementById("profissao").value;
    const cpf = document.getElementById("cpf").value;
    const identidade = document.getElementById("identidade").value;

    const rua = document.getElementById("rua").value;
    const numero = document.getElementById("numero").value;
    const cidade = document.getElementById("cidade").value;
    const estado = document.getElementById("estado").value;

    const apartamento = document.getElementById("apartamento").value;
    const meses = document.getElementById("meses").value;
    const data = document.getElementById("data").value;
    const valor = document.getElementById("valor").value;


    const primeiroNome = nome.trim().split(/\s+/)[0];

    // 🔹 MONTA O JSON
    const contrato = {
        locatario: {
            nome,
            nacionalidade,
            estadoCivil,
            profissao,
            cpf,
            identidade,
            endereco: {
                rua,
                numero,
                cidade,
                estado
            }
        },
        apartamento,
        meses,
        data,
        valor
    };

    console.log("Enviando:", contrato);

    try {
        // 🔹 REQUISIÇÃO PARA O BACKEND
        const response = await fetch("/download", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(contrato)
        });

        if (!response.ok) {
            throw new Error("Erro ao gerar PDF");
        }

        // 🔹 RECEBE O PDF
        const blob = await response.blob();

        // 🔹 CRIA DOWNLOAD
        const url = window.URL.createObjectURL(blob);

        const a = document.createElement("a");
        a.href = url;
        a.download = "contrato" + primeiroNome + ".pdf";
        document.body.appendChild(a);
        a.click();

        // 🔹 LIMPA
        a.remove();
        window.URL.revokeObjectURL(url);

    } catch (error) {
        console.error("Erro:", error);
    }
});