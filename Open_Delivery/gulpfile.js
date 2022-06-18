const gulp = require("gulp");
const sass = require("gulp-sass")(require("sass"));
const {src, series, parallel, dest, watch} = require("gulp");
//lista delle directory di scss
const sassList = [
    //common
    "./assets/scss/common/*.scss","./assets/scss/common/**/*.scss",
    //homepage
    "./assets/scss/homepage/*.scss", "./assets/scss/homepage/**/*.scss",
    //registrazione
    "./assets/scss/registrazione/*.scss", "./assets/scss/registrazione/**/*.scss",
];

const javaDir = "../OpenDelivery/src/main/resources/";

//per ogni nuova sezione di scss andrà fatta una funzione che la gestisce e andrà aggiunta a "allStyle"

function commonStyle(){
    //file da convertire
    return gulp.src("./assets/scss/common/main.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}
function homeStyle(){
    //file da convertire
    return gulp.src("./assets/scss/homepage/homepage.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function regStyle(){
    //file da convertire
    return gulp.src("./assets/scss/registrazione/registrazione.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

function html(){
    gulp.watch("*.html", ()=>{
        return gulp.src("*.html")
        .pipe(gulp.dest(javaDir + "templates"));
    })
}

function watchStyle(){
    gulp.watch(sassList,() => {
        commonStyle();
        homeStyle();
        regStyle();
        return gulp.src("./assets/css/*.css")
        .pipe(gulp.dest("../OpenDelivery/src/main/resources/static/assets/css"));
    });
}


exports.style = watchStyle;
exports.html = html;