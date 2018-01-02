package location.daoImpl;
import javax.sql.DataSource;

import org.kmsg.Mapper.GetLocationMapper;
import org.kmsg.model.Book;
import org.kmsg.model.GetLocationModel;
import org.kmsg.model.Price;
import org.springframework.jdbc.core.JdbcTemplate;

import location.daoint.LocationDao;

public class LocationdaoImpl implements LocationDao
{
	JdbcTemplate jdbctemplate=new JdbcTemplate();
	@Override
	public void setDataSource(DataSource dataSource)
	{
		jdbctemplate=new JdbcTemplate(dataSource);
	}
	public boolean saveLocationData(int busid,int routeid,String latitude,String longitude,String timestamp)
	{
		String sql="insert into Location(busid,routeid,lati,longi,dttime) values(?,?,?,?,STR_TO_DATE(?,'%d-%m-%Y %H:%i:%s'))";
		return jdbctemplate.update(sql,new Object[]{busid,routeid,latitude,longitude,timestamp}) == 1 ;
		
	}
	public GetLocationModel getLocationData()
	{
		String sql=" select  * "
				+ " from Location order by dttime desc limit 1 ";
		
		
		return jdbctemplate.queryForObject(sql,new GetLocationMapper());
		
		
		
	}
	public boolean saveBookData(Book bookModel) {
		
		String sql="insert into book(id,language,edition,author) values(?,?,?,?)";
		return jdbctemplate.update(sql,new Object[]{
		             bookModel.getId(),
		             bookModel.getLanguage(),
		             bookModel.getEdition(),
		             bookModel.getAuthor()
		})==1;
		
	}
	public boolean savePriceData(Price price) {

		String sql="insert into price(type,price) values(?,?)";
		return jdbctemplate.update(sql,new Object[]{
		             price.getType(),
		             price.getPrice(),
		             		
		})==1;
		
	}

}
