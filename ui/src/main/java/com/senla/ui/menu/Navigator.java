package com.senla.ui.menu;




import com.senla.util.Printer;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;


import java.util.List;
@Log4j
@Component
public class Navigator  {
    
    private Menu currentMenu;

    private Navigator() {
    }


    public void printMenu(){
        Printer.print(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            Printer.print((i + 1) + ". " + item.getTitle());
        }
    }

    public void navigate(int index) {
        try {
            if (currentMenu != null) {
                MenuItem menuItem = currentMenu.getMenuItems().get(index-1);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();
            }
        } catch (Exception e) {
            log.error("failed", e);
        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
    public Menu getCurrentMenu() {
        return currentMenu;
    }
}