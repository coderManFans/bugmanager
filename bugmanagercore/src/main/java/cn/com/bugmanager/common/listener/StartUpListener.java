package cn.com.bugmanager.common.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by fcs on 2015/3/23.
 */
public class StartUpListener  implements ServletContextListener{
    private Logger logger = LoggerFactory.getLogger(StartUpListener.class);


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        logger.info("------"+servletContextEvent.getServletContext().getContextPath()+"framework init -----");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        logger.info("------"+servletContextEvent.getServletContext().getContextPath()+"framework destroied -----");
    }
}
