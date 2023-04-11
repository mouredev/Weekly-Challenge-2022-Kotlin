# Crea una función que evalúe si un/a atleta ha superado correctamente una
# carrera de obstáculos.
# - La función recibirá dos parámetros:
#      - Un array que sólo puede contener String con las palabras
#        "run" o "jump"
#      - Un String que represente la pista y sólo puede contener "_" (suelo)
#        o "|" (valla)
# - La función imprimirá cómo ha finalizado la carrera:
#      - Si el/a atleta hace "run" en "_" (suelo) y "jump" en "|" (valla)
#        será correcto y no variará el símbolo de esa parte de la pista.
#      - Si hace "jump" en "_" (suelo), se variará la pista por "x".
#      - Si hace "run" en "|" (valla), se variará la pista por "/".
# - La función retornará un Boolean que indique si ha superado la carrera.
# Para ello tiene que realizar la opción correcta en cada tramo de la pista.

# Hora de inicio 19:22
# Hora de cierre 19:49


def run_track(actionsRun, track)
    trackSplit = track.split("")
    validateArray = []

    trackSplit.each_with_index do |segment, index|
        if  (segment == "_")
           trackSplit[index]= actionsRun[index] == "run" ? "_":"x"
        end
        if segment == "|" 
           trackSplit[index]= actionsRun[index] == "jump" ? "|":"/"
        end

    end

    track=trackSplit.join()
    puts trackSplit.any?{|x| ["x","/"].include?(x)} ? "Don't pass the run 💀 #{track}" :
    "Pass the run #{track} 🏃"
end

 print run_track(["run","run","run"],"___")  # Paso la carrera: ___🏃‍♂✅
 print run_track(["run","jump","run"],"___")  #  No paso 
 print run_track(["jump","jump","jump"],"|||")  #  Pasa los saltos
 print run_track(["jump","jump","jump"],"||_")  #  No pasa