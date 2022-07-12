//importazzi vari da gulp
const gulp = require("gulp");
const sass = require("gulp-sass")(require("sass"));
const { src, series, parallel, dest, watch } = require("gulp");


//lista delle directory di scss
const sassList = [
    //common
    "./assets/scss/common/*.scss", "./assets/scss/common/**/*.scss",
    //homepage
    "./assets/scss/homepage/*.scss", "./assets/scss/homepage/**/*.scss",
    //registrazione
    "./assets/scss/registrazione/*.scss", "./assets/scss/registrazione/**/*.scss",
    //moreRestaurant
    "./assets/scss/moreRestaurants/*.scss", "./assets/scss/moreRestaurants/**/*.scss",
    //login
    "./assets/scss/login/*.scss", "./assets/scss/login/**/*.scss",
    //allergie registrazione
    "./assets/scss/allergie-iscrizione/*.scss", "./assets/scss/allergie-iscrizione/**/*.scss",
    //carrello
    "./assets/scss/cart/*.scss", "./assets/scss/cart/**/*.scss",
    //ricerca
    "./assets/scss/ricerca/*.scss", "./assets/scss/ricerca/**/*.scss",
];

const javaDir = "../main/resources/";

//per ogni nuova sezione di scss andrà fatta una funzione che la gestisce e andrà aggiunta a "allStyle"

function searchStyle(){
    return gulp.src("./assets/scss/ricerca/ricerca.scss")
    .pipe(sass())
    .pipe(gulp.dest("./assets/css"));
}

function commonStyle() {
    //file da convertire
    return gulp.src("./assets/scss/common/main.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function cartStyle(){
    return gulp.src("./assets/scss/cart/cart.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function loginstyle() {
    return gulp.src("./assets/scss/login/login.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function alliscrizione() {
    return gulp.src("./assets/scss/allergie-iscrizione/allergie-iscrizione.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function homeStyle() {
    //file da convertire
    return gulp.src("./assets/scss/homepage/homepage.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function regStyle() {
    //file da convertire
    return gulp.src("./assets/scss/registrazione/registrazione.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function html() {
    const localJavaDir = javaDir + "templates/";

    //da qua a java
    gulp.watch("*.html", () => {
        return gulp.src("*.html")
            .pipe(gulp.dest(localJavaDir));
    });
    //da java a qua

    //NOTA: ciclo infinto [redacted], i due watch si alimentano a vicenda
    /*gulp.watch(localJavaDir + "*.html", ()=>{
        return gulp.src(localJavaDir + "*.html")
        .pipe(gulp.dest("./"));
    });*/
}

function moreRestaurantsStyle() {
    //file da convertire
    return gulp.src("./assets/scss/moreRestaurants/moreRestaurants.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function processStyle() {
    commonStyle();
    homeStyle();
    regStyle();
    moreRestaurantsStyle();
    loginstyle();
    alliscrizione();
    cartStyle();
    searchStyle();

    return gulp.src("./assets/css/*.css")
        .pipe(gulp.dest(javaDir + "/static/assets/css"));
}


function watchStyle() {

    processStyle();

    console.log("watching sass...");
    gulp.watch(sassList, () => {
        processStyle();
        return gulp.src("./assets/css/*.css")
            .pipe(gulp.dest(javaDir + "/static/assets/css"));
    });
}

function processReverseHtml(){
    console.log("first compile");
    return gulp.src(javaDir + "templates/*.html")
            .pipe(gulp.dest("./"));
}

exports.style = watchStyle;
exports.html = html;
exports.all = () => {
    watchStyle();
    html();
};
exports.reverse = () => {
    processReverseHtml()
    gulp.watch(javaDir + "templates/*.html", () => {
        return gulp.src(javaDir + "templates/*.html")
            .pipe(gulp.dest("./"));
    })
};

