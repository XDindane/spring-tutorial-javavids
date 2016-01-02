package spring.tutorial.javavids.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import org.springframework.stereotype.Service;
import spring.tutorial.javavids.entity.Item;
import spring.tutorial.javavids.exception.RssException;
import spring.tutorial.javavids.rss.ObjectFactory;
import spring.tutorial.javavids.rss.TRss;
import spring.tutorial.javavids.rss.TRssChannel;
import spring.tutorial.javavids.rss.TRssItem;

/**
 *
 */
@Service
public class RssService {

    public List<Item> getItems(Source source) throws RssException {
        ArrayList<Item> list = new ArrayList<Item>();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
            TRss rss = jaxbElement.getValue();

            List<TRssChannel> channels = rss.getChannel();
            for (TRssChannel channel : channels) {
                List<TRssItem> items = channel.getItem();
                
                for (TRssItem rssItem : items) {
                    Item item = new Item();
                    item.setTitle(rssItem.getTitle());
                    item.setDescription(rssItem.getDescription());
                    item.setLink(rssItem.getLink());
                    Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(rssItem.getPubDate());
                    item.setPublishedDate(pubDate);
                    list.add(item);
                }
            }

        } catch (JAXBException | ParseException e) {
            throw new RssException(e);
        }
        return list;

    }

}
