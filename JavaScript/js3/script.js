function generate(){
    var quotes={
        "- Aaron Lauritsen":'"There is strange comfort in knowing that no matter what happens today, the Sun will rise again tomorrow."'
         ,"Alysha Speer":'"You never really know what coming. A small wave, or maybe a big one. All you can really do is hope that when it comes, you can surf over it, instead of drown in its monstrosity."'
         ,   "- John Galsworthy":'"Life calls the tune, we dance."'
         , "- NARUTO UZUMAKI":'"HARD WORK IS WORTHLESS FOR THOSE THAT DON’T BELIEVE IN THEMSELVES."'
         , " – OBITO UCHIHA":'"THE MOMENT PEOPLE COME TO KNOW LOVE, THEY RUN THE RISK OF CARRYING HATE."'
         ,"– ITACHI UCHIHA":'"THOSE WHO FORGIVE THEMSELVES, AND ARE ABLE TO ACCEPT THEIR TRUE NATURE… THEY ARE THE STRONG ONES!"'

    }

    var authors=Object.keys(quotes);

    var author =authors[Math.floor(Math.random()* authors.length)];

    var quote=quotes[author];

    document.getElementById("quotes").innerHTML=quote;
    document.getElementById("author").innerHTML=author;

   
}