Feature: Prueba al login del usuario automatico
  Yo como usuario de Guru Bank
  Quiero poder ingresar a mi sucursal virtual
  Para acceder a los servicios de mi banco
  
    
  Scenario Outline: El usuario se puede logear con credenciales validas
    Given el usuario esta en la pagina de login
    When el usuario ingresa su usuario "<usuario>"
    And el usuario ingresa su contrasena "<password>"
    And el usuario da cliente en el boton de login
    Then el usuario puede ver el panel de la sucursal virtual
    
  Examples:
    | usuario   | password | mensaje                |
    | mngr366185| EsEsYqY  | Manger Id : mngr366185 |
    
        
  Scenario Outline: El usuario ingresa credenciales invalidas
    Given el usuario esta en la pagina de login
    When el usuario ingresa su usuario "mngr366185"
    And el usuario ingresa su contrasena "EsEsYqYfun"
    And el usuario da cliente en el boton de login
    Then el usuario no puede entrar en la sucursal virtual
    

    

    


    
    
 


