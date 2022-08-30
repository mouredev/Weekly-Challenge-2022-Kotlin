
#Efectividades para los diferentes tipos de pokemon
pokemon_water = {'fire_efectivity':2,'water_efectivity':1,'plant_efectivity':1,'elec_efectivity':0.5}
pokemon_fire = {'fire_efectivity':1,'water_efectivity':0.5,'plant_efectivity':2,'elec_efectivity':0.5}
pokemon_plant = {'fire_efectivity':0.5,'water_efectivity':1,'plant_efectivity':1,'elec_efectivity':2}
pokemon_elect = {'fire_efectivity':1,'water_efectivity':2,'plant_efectivity':0.5,'elec_efectivity':1}


def batPokemon(type_atc,type_def,atack,defence):
    #Casos para pokemon tipo agua
    if(type_atc=='water' or type_atc=='agua' and atack<=100 and atack>=1):
       if(type_def == 'fire' or type_def=='fuego' and defence<=100 and defence>=1):
           damage = 50*(atack/defence)*pokemon_water['fire_efectivity']
           return damage
    if(type_atc=='water' or type_atc=='agua' and atack<=100 and atack>=1):
           if(type_def == 'water' or type_def=='agua' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_water['water_efectivity']
            return damage
    if(type_atc=='water' or type_atc=='agua' and atack<=100 and atack>=1):
           if(type_def == 'plant' or type_def=='planta' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_water['plant_efectivity']
            return damage     
    if(type_atc=='water' or type_atc=='agua' and atack<=100 and atack>=1):
           if(type_def == 'electric' or type_def=='electrico' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_water['elec_efectivity']
            return damage     
     
     
        
    #Casos para pokemon tipo fuego
    if(type_atc=='fire' or type_atc=='fuego' and atack<=100 and atack>=1):
       if(type_def == 'fire' or type_def=='fuego' and defence<=100 and defence>=1):
           damage = 50*(atack/defence)*pokemon_fire['fire_efectivity']
           return damage
    if(type_atc=='fire' or type_atc=='fuego' and atack<=100 and atack>=1):
           if(type_def == 'water' or type_def=='agua' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_fire['water_efectivity']
            return damage
    if(type_atc=='fire' or type_atc=='fuego' and atack<=100 and atack>=1):
           if(type_def == 'plant' or type_def=='planta' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_fire['plant_efectivity']
            return damage     
    if(type_atc=='fire' or type_atc=='fuego' and atack<=100 and atack>=1):
           if(type_def == 'electric' or type_def=='electrico' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_fire['elec_efectivity']
            return damage 
        
    
    #Casos para pokemon tipo electrico
    if(type_atc=='electric' or type_atc=='electrico' and atack<=100 and atack>=1):
       if(type_def == 'fire' or type_def=='fuego' and defence<=100 and defence>=1):
           damage = 50*(atack/defence)*pokemon_plant['fire_efectivity']
           return damage
    if(type_atc=='electric' or type_atc=='electrico'  and atack<=100 and atack>=1):
           if(type_atc=='electric' or type_atc=='electrico' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_plant['water_efectivity']
            return damage
    if(type_atc=='electric' or type_atc=='electrico'  and atack<=100 and atack>=1):
           if(type_def == 'plant' or type_def=='planta' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_plant['plant_efectivity']
            return damage     
    if(type_atc=='electric' or type_atc=='electrico'  and atack<=100 and atack>=1):
           if(type_def == 'electric' or type_def=='electrico' and defence<=100 and defence>=1):
            damage = 50*(atack/defence)*pokemon_plant['elec_efectivity']
            return damage                 
    error = 'Error: Los unicos tipos de pokemon soportados son agua,fuego,planta o electrico y los valores de ataque deben estar entre 1 y 100 '        
    return error


