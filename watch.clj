(require 'cljs.build.api)

(cljs.build.api/watch "src"
  {:optimizations :advanced
   :output-to "index.android.js"})
