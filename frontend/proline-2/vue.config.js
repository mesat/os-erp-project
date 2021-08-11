module.exports = {
    lintOnSave: false,
    runtimeCompiler: true,
    configureWebpack: {
        //Necessary to run npm link https://webpack.js.org/configuration/resolve/#resolve-symlinks
        resolve: {
            symlinks: false
        }
    },
    transpileDependencies: [
        '@coreui/utils',
        '@coreui/vue'
    ],/*
    devServer: {
        proxy: {
            "^/api": {
                target: "https://os-erp.herokuapp.com/",
                ws:true,
                changeOrigin: true,
                pathRewrite: { "^/api": "" }
            }
        }
    }*/
}
