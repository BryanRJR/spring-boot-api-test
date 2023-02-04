package id.bcasyariah.library.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequest {
    private String judul;
    private String penerbit;
    private String pengarang;
    private String tahun;
    private String kategori;

}
