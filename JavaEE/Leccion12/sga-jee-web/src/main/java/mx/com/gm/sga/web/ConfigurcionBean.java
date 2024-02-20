/*
 * En versiones posteriores a GlashFish5 este archivo de configuración no es necesario
 */
package mx.com.gm.sga.web;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import static javax.faces.annotation.FacesConfig.Version.JSF_2_3;

/**
 *
 * @author antonio
 */

@FacesConfig(version=JSF_2_3)
@ApplicationScoped      //Para que funcione en el ámbito de toda la aplicación
public class ConfigurcionBean {

}
