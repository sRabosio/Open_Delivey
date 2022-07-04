//importazzi vari da gulp
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

const javaDir = "../main/resources/";

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
    const localJavaDir = javaDir + "templates/";

    //da qua a java
    gulp.watch("*.html", ()=>{
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

function processStyle(){
    commonStyle();
    homeStyle();
    regStyle();

    return gulp.src("./assets/css/*.css")
        .pipe(gulp.dest(javaDir + "/static/assets/css"));
}


function watchStyle(){
    
    processStyle();

    console.log("watching sass...");
    gulp.watch(sassList,() => {
        processStyle();     
        return gulp.src("./assets/css/*.css")
        .pipe(gulp.dest(javaDir + "/static/assets/css"));   
    });
}


exports.style = watchStyle;
exports.html = html;
exports.all = ()=>{
    watchStyle();
    html();
};
exports.reverse = ()=>{
    gulp.watch(javaDir + "templates/*.html", ()=>{
        return gulp.src(javaDir + "templates/*.html")
        .pipe(gulp.dest("./"));
    })
};