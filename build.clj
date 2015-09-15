(require 'cljs.build.api)

(cljs.build.api/build "src"
  {:optimizations :advanced
   :output-to "index.android.js"})

(System/exit 0)
