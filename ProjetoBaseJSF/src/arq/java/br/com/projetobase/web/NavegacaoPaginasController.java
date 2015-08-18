package br.com.projetobase.web;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewParameter;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewDeclarationLanguage;
import javax.faces.view.ViewMetadata;

@ApplicationScoped
public class NavegacaoPaginasController {
	public static class Pagina {
		
		private final String viewId;
		
		private final Map<String, String> params;

		private Pagina(String viewId) {
			this.viewId = viewId;
			this.params = new LinkedHashMap<String, String>();
		}

		private Pagina(String viewId, Map<String, String> params) {
			this.viewId = viewId;
			this.params = params;
		}

		public Pagina redirect() {
			return includeParam("faces-redirect", "true");
		}

		public Pagina includeViewParams() {
			return includeParam("includeViewParams", "true");
		}

		public Pagina includeViewParam(String name) {
			// Getting the metadata facet of the view
			FacesContext ctx = FacesContext.getCurrentInstance();
			ViewDeclarationLanguage vdl = ctx.getApplication().getViewHandler().getViewDeclarationLanguage(ctx, viewId);
			ViewMetadata viewMetadata = vdl.getViewMetadata(ctx, viewId);
			UIViewRoot viewRoot = viewMetadata.createMetadataView(ctx);
			UIComponent metadataFacet = viewRoot.getFacet(UIViewRoot.METADATA_FACET_NAME);

			// Looking for a view parameter with the specified name
			UIViewParameter viewParam = null;
			for (UIComponent child : metadataFacet.getChildren()) {
				if (child instanceof UIViewParameter) {
					UIViewParameter tempViewParam = (UIViewParameter) child;
					if (name.equals(tempViewParam.getName())) {
						viewParam = tempViewParam;
						break;
					}
				}
			}

			if (viewParam == null) {
				throw new FacesException("Unknown parameter: '" + name + "' for view: " + viewId);
			}

			// Getting the value
			String value = viewParam.getStringValue(ctx);
			return includeParam(name, value);
		}

		public Pagina includeParam(String name, String value) {
			Map<String, String> newParams = new LinkedHashMap<String, String>(params);
			newParams.put(name, value);
			return new Pagina(viewId, newParams);
		}

		public String construir() {
			StringBuilder sb = new StringBuilder();
			sb.append(viewId);

			String paramSeparator = "?";
			for (Map.Entry<String, String> nameValue : params.entrySet()) {
				sb.append(paramSeparator).append(nameValue.getKey()).append("=").append(nameValue.getValue());
				paramSeparator = "&";
			}

			return sb.toString();
		}
	}
	
    private final Pagina login = new Pagina("/singin");
    private final Pagina cadastro = new Pagina("/singup");
    private final Pagina home = new Pagina("/paginas/home");
    private final Pagina areaDoUsuario = new Pagina("/paginas/usuario/homepage");
    private final Pagina FalhaDeLogin = new Pagina("/paginas/FalhaDeLogin");
    private final Pagina CadastroEquipamento = new Pagina("/paginas/equipamento/cadastro");
    private final Pagina CadastroSensor = new Pagina("/paginas/sensor/cadastro");
    private final Pagina EditarEquipamento = new Pagina("/paginas/equipamento/edit");
    private final Pagina EditarSensor = new Pagina("/paginas/sensor/edit");
	public Pagina getEditarEquipamento() {
		return EditarEquipamento;
	}

	public Pagina getEditarSensor() {
		return EditarSensor;
	}

	public Pagina getCadastro() {
		return cadastro;
	}

	public Pagina getLogin() {
		return login;
	}
	
	public Pagina getHome(){
		return home;
	}
	
	public Pagina getAreaDoUsuario(){
		return areaDoUsuario;
	}

	public Pagina getFalhaDeLogin() {
		return FalhaDeLogin;
	}

	public Pagina getCadastroEquipamento() {
		return CadastroEquipamento;
	}

	public Pagina getCadastroSensor() {
		return CadastroSensor;
	}
	
}
