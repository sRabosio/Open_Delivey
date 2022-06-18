const gulp = require("gulp");
const sass = require("gulp-sass")(require("sass"));
const {src, series, parallel, dest, watch} = require("gulp");


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

function style(){
    return commonStyle(),
    homeStyle(),
    regStyle()

}


exports.style = style;