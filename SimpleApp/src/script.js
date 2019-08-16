const nodeUrl = "";
let contractAddress = "0xa0809b9d7f6d950a988c79a897088d36c2221f60a32a6bc4de41eda50bbbb802";
const web3 = new Web3(new Web3.providers.HttpProvider(nodeUrl));


async function getString() {
    let initialResponse = await web3.eth.call({to:contractAddress, data:web3.avm.contract.method("aipXXXGetFavoriteString").encode()});
    let avmResponse = await web3.avm.contract.decode("string", initialResponse);
    document.querySelector('#current_string_output').innerHTML = avmResponse;
}

async function setString() {

    document.querySelector('#submit_button').innerHTML = 'Loading...';
    document.querySelector('#submit_button').disabled = true;

    let newStringInput = document.querySelector("#new_string_input").value;

    let data = web3.avm.contract
        .method("aipXXXSetFavoriteString")
        .inputs(["string"], [newStringInput])
        .encode();

    const transactionObject = {
        to: contractAddress,
        data: data,
        gasPrice: 10000000000,
        gas: 2000000,
    };

    let txHash = await aionweb3.sendTransaction(transactionObject);
    console.log("txHash", txHash);

    let timer = setInterval(
        async function() {
            if(await web3.eth.getTransactionReceipt(txHash)){
                console.log("getTransactionReceipt", txHash);
                console.log("onTxComplete");
                document.querySelector('#submit_button').innerHTML = 'Submit';
                document.querySelector('#submit_button').disabled = false;
                getString();
                clearInterval(timer);
            } else {
                console.log("Txn Pending", txHash);
            }
        },
        1000
    );


}

window.onload = function() {
    getString();
}
