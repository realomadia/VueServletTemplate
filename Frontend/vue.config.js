module.exports = {
  transpileDependencies: true,
  devServer: {
      proxy: {
          '/api': {
              target: 'http://127.0.0.1:8089/backend',
              ws: true,
              changeOrigin: true
          }
      }
  }
}