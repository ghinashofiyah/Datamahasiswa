
package datamahasiswa;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.json.*;



public class Datamahasiswa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HttpResponse<String> response = Unirest.post("https://siakad.itmnganjuk.ac.id/api/select")
                .header("Content-Type", "application/json")
                .header("Cookie", "siakaditm1=rj7hej3hjcp1raoaj50a8gmuao")
                .body("{\"token\" : \"ufb2a73ed1e2bae2403ea3b3e9b5eb86ed6fdb66b49\",\r\n\"query\" : \"select * from t_mhs where angkatan = 2023 and deleted = 0 limit 200\"}\r\n")
                .asString();
        
        String jsonresponse = response.getBody();
        JSONObject obj = new JSONObject(jsonresponse);
        int rows = obj.getInt("rows");
        JSONArray results = obj.getJSONArray("results");
        if (rows != 0) {
            for (int i = 0; i < results.length(); i++) {
                JSONObject item = results.getJSONObject(i);
                String nama = item.getString("mhs_nama");
                System.out.println(nama);
            }
            
        }


//        System.out.println(results);

          
    }
    
}
