package .service.interfaces;

import .dto.request.ProductDTO;
import com.paymentapi.paymentapi.dto.response.ProductResponseDTO;
import com.paymentapi.paymentapi.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> findAll(Example example, Pageable pageable);

    ProductResponseDTO findById(Integer id);

    ProductResponseDTO findByDescription(String description);

    void deleteById(Integer id);

    ProductResponseDTO save(ProductDTO productDTO);

    ProductResponseDTO update(Integer id, ProductDTO productDTO);

    Page<ProductResponseDTO> findAllByExample(Pageable pageable, ProductDTO filter);
}
