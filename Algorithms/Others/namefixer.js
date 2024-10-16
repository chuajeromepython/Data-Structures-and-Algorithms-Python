let name = prompt("Enter a very long name : ");

let spil = name.split(" ");
const first_letter = [];
const subs = [];
const capitalized_name = [];
for(let i = 0 ; i < spil.length ; i++){
    first_letter.push(spil[i].charAt(0).toUpperCase());
    subs.push(spil[i].substr(1,spil[i].length - 1).toLowerCase());
    
}
for(let i = 0 ; i < spil.length ; i++){

    capitalized_name.push(first_letter[i] + subs[i]);
}
alert(capitalized_name.join(" "));
