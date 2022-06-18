const gulp = require("gulp");
const sass = require("gulp-sass");
const {src, series, parallel, dest, watch} = require("gulp");

function style(){
    //file da convertire
    return gulp.src("./assets/scss/**/*.scss")

    .pipe(sass())

    .pipe(gulp.dest("./assets/css"))
}

exports.style = style;