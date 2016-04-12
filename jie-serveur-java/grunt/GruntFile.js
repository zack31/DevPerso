module.exports = function(grunt) { 
    // pour ne pas répéter ce préfix dans tout les chemins
    var $$ = function(scriptname) {
        return "../src/main/webapp/" + scriptname;
    };
    grunt.initConfig({
        concat: {
            options: {
                separator: ' '
            },
            jslibs:{
                src:[
                    $$('lib/jquery/jquery.js'),
                    $$('lib/bootstrap/dist/js/bootstrap.min.js'),
                    $$('lib/select2/select2.min.js'),
                    $$('lib/smalot-bootstrap-datetimepicker/js/bootstrap-datetimepicker.js'),
                    $$('lib/smalot-bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.fr.js'),
                    $$('lib/flot/jquery.flot.js'),
                    $$('lib/flot/jquery.flot.pie.js'),
                    $$('lib/angular/angular.js'),
                    $$('lib/angular-cookies/angular-cookies.min.js'),
                    $$('lib/angular-route/angular-route.min.js'),
                    $$('lib/angular-bootstrap/ui-bootstrap-tpls.js'),
                    $$('lib/angular-ui-select2/src/select2.js'),
                ],
                dest:$$('js/libs.js')
            },
            js: {
                src: [
                    $$('js/app.js'),
                    $$('js/app.config.js'),
                    $$('js/common/interceptors/interceptor.js'),
                    $$('js/common/services/loadingSpinner.js'),
                    $$('js/common/services/ajaxModule.js'),
                    $$('js/common/directives/datetimePicker.js'),
                    $$('js/common/directives/flot.js'),
                    $$('js/modules/index/indexController.js'),
                    $$('js/modules/login/controllers/loginController.js'),
                    $$('js/modules/login/services/loginService.js'),
                    $$('js/modules/dashboard/controllers/dashIndexController.js'),
                    $$('js/modules/mbsc/controllers/mbscDetailController.js'),
                    $$('js/modules/mbsc/services/MbscService.js'),
                    $$('js/modules/bts/controllers/btsDetailController.js'),
                    $$('js/modules/bts/services/BtsService.js'),
                    $$('js/modules/gcell/controllers/gcellDetailController.js'),
                    $$('js/modules/gcell/services/GcellService.js'),
                    $$('js/modules/gtrx/controllers/gtrxDetailController.js'),
                    $$('js/modules/gtrx/services/GtrxService.js'),
                    
                ],
                dest: $$('js/script.js') //where to output the script
            },
            alljs:{
                src:[
                    $$('js/libs.js'),
                    $$('js/script.min.js')
                ],
                dest:$$('js/app.min.js')
            },
            css: {
                src: [
                    $$('lib/bootstrap/dist/css/bootstrap.css'),
                    $$('lib/bootstrap/dist/css/bootstrap-theme.css'),
                    $$('lib/select2/select2.css'),
                    $$('lib/smalot-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css'),
                    $$('css/loadingSpinner.css'),
                    $$('css/style.css'),
                    
                ],
                dest: $$('css/concat.css')
            }
        },
        ngmin: {
            file: {
                src: [$$('js/script.js')],
                dest: $$('js/script.annotated.js')
            }
        },
        closureCompiler: {
            options: {
                compilerFile: 'closureCompiler.jar',
                compilerOpts: {
                    compilation_level: 'SIMPLE_OPTIMIZATIONS',
                }
            },
            targetName: {
                src: $$('js/script.annotated.js'),
                dest: $$('js/script.min.js')
            }
        },
        cssmin: {
            css: {
                options: {
                    keepSpecialComments: 0
                },
                src: $$('css/concat.css'),
                dest: $$('css/style.min.css')
            }
        },
        clean: {
                options: { force: true },
                build:[
                    $$('js/script.js'),
                    $$('js/script.min.js'),
                    $$('js/libs.js'),
                    $$('js/script.annotated.js'),
                    $$('css/concat.css'),
                ]
        }
    });
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-ngmin');
    grunt.loadNpmTasks('grunt-closure-tools');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-css');

    grunt.registerTask('default', ['concat:css','concat:jslibs','concat:js', 'ngmin', 'closureCompiler','concat:alljs', 'cssmin', 'clean']);
};
