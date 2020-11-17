package br.com.fiap.saveshare.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.fiap.saveshare.models.Imovel;
import br.com.fiap.saveshare.models.ImovelFoto;
import br.com.fiap.saveshare.models.Usuario;
import br.com.fiap.saveshare.repositories.ImovelFotoRepository;
import br.com.fiap.saveshare.services.exceptions.FileException;
import br.com.fiap.saveshare.services.exceptions.ObjectNotFoundException;

@Service
public class ImovelFotoService {
	
	@Autowired
	private ImovelFotoRepository repo;
	
	@Autowired
	private ImovelService imovelService;
	
	@Autowired
	private UsuarioService usuarioService;

	public ImovelFoto insert(MultipartFile file, String legenda, Integer idUsuario, Integer idImovel) {
		Imovel imovel = imovelService.find(idImovel);
		Usuario usuario = usuarioService.find(idUsuario);
		ImovelFoto foto = new ImovelFoto();
		try {
			foto.setLegenda(legenda);
			foto.setFoto(file.getBytes());
			foto.setIdFotoImovel(null);
			foto.setImovel(imovel);
			foto.setUsuario(usuario);
			foto = repo.save(foto);
		} catch (IOException e) {
			throw new FileException("Erro de IO: " + e.getMessage());
		}

		return foto;
	}
	
	public List<ImovelFoto> findFotosImovel(Integer idImovel){
		Imovel imovel = imovelService.find(idImovel);
		return repo.findByImovel(imovel);
	}

	public ImovelFoto find(Integer id) {
		Optional<ImovelFoto> imovelFoto = repo.findById(id);
		return imovelFoto.orElseThrow(()-> new ObjectNotFoundException(
				"Foto Imóvel não encontrada Id: " + id + ", Tipo: " + ImovelFoto.class.getName()));
	}
	
	

}
