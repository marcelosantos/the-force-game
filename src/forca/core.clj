(ns forca.core
  (:gen-class))

(def total-de-vidas 6)

(defn perdeu [] (print "Você perdeu!!! "))
(defn ganhou [] (print "Você ganhou!!!"))

(defn letras-faltantes [palavra acertos]
	(remove (fn [letra] (contains? acertos (str letra))) palavra)
)

(defn acertou-a-palavra-toda? [palavra acertos]
	(empty? (letras-faltantes palavra acertos))
)

(defn jogo [vidas palavra acertos]
	(if (= vidas 0)
		(perdeu)
		(if (acertou-a-palavra-toda? palavra acertos)
			(ganhou)
			(print "Chuta, amigo!")
		)
	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
