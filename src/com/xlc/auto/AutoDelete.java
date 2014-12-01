package com.xlc.auto;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AutoDelete {

	public static void main(String[] args) {

		AutoDelete s = new AutoDelete();

		s.autoDeleteConnectionMsg();

		s.autoDeleteSilentMsg();

		s.autoNotifacationScreenMsg();

		s.autoDownloadMsg();
		
		s.autoInstall_msg_hour();

	}

	/**
	 * 
	 * 分段删除表中数据，每次删除5000条
	 */
	public void autoDeleteConnectionMsg() {

		String sql = "delete from tbl_app_connection_message where DATE_FORMAT(c_date,'%c') < DATE_FORMAT(CURDATE(),'%c')-2 limit 5000";

		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);

			while (true) {

				int s = ps.executeUpdate();

				if (s == 0) {

					break;

				}

				Thread.sleep(10 * 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBConnection.closeConnection(conn, ps, null);

		}

	}

	/**
	 * 
	 * 分段删除静默概要数据，每次删除5000条
	 */
	public void autoDeleteSilentMsg() {

		String sql = "delete from tbl_install_msg where DATE_FORMAT(c_date,'%c') < DATE_FORMAT(CURDATE(),'%c')-2 limit 5000";

		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);

			while (true) {

				int s = ps.executeUpdate();

				if (s == 0) {

					break;

				}
				Thread.sleep(20 * 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, ps, null);
		}

	}

	/**
	 * 
	 * 分段删除 广告概要，每次删除5000条
	 */
	public void autoNotifacationScreenMsg() {

		String sql = "delete from tbl_software_installed where DATE_FORMAT(c_date,'%c') < DATE_FORMAT(CURDATE(),'%c')-2 limit 5000";

		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);

			while (true) {

				int s = ps.executeUpdate();

				if (s == 0) {

					break;

				}
				Thread.sleep(10 * 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, ps, null);
		}

	}

	/**
	 * 
	 * 分段删除 广告概要，每次删除5000条
	 */
	public void autoDownloadMsg() {

		String sql = "delete from appdownloadmsg where DATE_FORMAT(c_date,'%c') < DATE_FORMAT(CURDATE(),'%c')-2 limit 5000";

		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);

			while (true) {

				int s = ps.executeUpdate();

				if (s == 0) {

					break;

				}
				Thread.sleep(10 * 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, ps, null);
		}

	}

	// tbl_install_msg_hour

	public void autoInstall_msg_hour() {

		String sql = "delete from tbl_install_msg_hour where DATE_FORMAT(c_date,'%c') < DATE_FORMAT(CURDATE(),'%c')-2 limit 5000";

		Connection conn = DBConnection.getConnection();

		PreparedStatement ps = null;

		try {

			ps = conn.prepareStatement(sql);

			while (true) {

				int s = ps.executeUpdate();

				if (s == 0) {

					break;

				}
				Thread.sleep(10 * 1000);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, ps, null);
		}

	}

}
