(defproject theforcegame "0.1.0-SNAPSHOT"
  :description "THE FORCE GAME: This is an simples force game developed using Clojure"
  :url "https://github.com/marcelosantos/theforcegame"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot theforcegame.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
